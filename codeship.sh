## Variables to set in ENVIRONMENT
TIMEOUT=${TIMEOUT:=900}
SUCCESS_RATE=${SUCCESS_RATE:=0}
RESPONSE_TIME=${RESPONSE_TIME:=10000}
REDLINE_API_KEY=${REDLINE_API_KEY:='SET YOUR KEY'}

## Execute Load Test
OUT=$(curl -s https://www.redline13.com/Api/LoadTest \
  -H "X-Redline-Auth: ${REDLINE_API_KEY}" \
  -F testType=jmeter-test \
  -F name=CodeShipAndRedLine13 \
  -F "file=@`pwd`/tests/Plexify.jmx" \
  -F numServers=1 \
  -F storeOutput=T \
  -F servers[0][location]=us-east-1 \
  -F servers[0][size]=m3.medium \
  -F servers[0][num]=1 \
  -F servers[0][onDemand]=T \
  -F servers[0][usersPerServer]=1)
LOADTEST=$(echo $OUT | jq '.loadTestId | tonumber' )
echo "TRACKING LOAD TEST ($LOADTEST), kill test after 15 minutes"

if [ "$LOADTEST" == "" ]; then
  echo "LOADTEST FAILED TO CREATE"
  echo $OUT
  exit 1
fi

## Setup End Time to catch long running tests ( 900 seconds )
endTime=$(( $(date +%s) + TIMEOUT ))

## Loop until test completes or time is up and kill test.
COMPLETE=false
while [ $(date +%s) -lt $endTime -a $COMPLETE == "false" ];
do
  sleep 30
  OUT=$(curl -s https://www.redline13.com/Api/LoadTest?loadTestId=$LOADTEST \
    -H "X-Redline-Auth: ${REDLINE_API_KEY}")
  COMPLETE=$( echo $OUT | jq '.[0].completed_time != .[0].cancelled_time')
  echo "TEST RUNNING"
done

if [ $COMPLETE == "false" ]; then
  echo "TEST DID NOT COMPLETE IN TIME"
  echo "Check test at https://www.redline13.com/LoadTest/View/$LOADTEST"
  exit 1
fi

echo "Test Report and Graphs can be viewed https://www.redline13.com/LoadTest/View/$LOADTEST"

## CHECK STATS FOR SUCCESS FAILURE
RESULT=$(curl -s https://www.redline13.com/Api/LoadTest?loadTestId=$LOADTEST \
  -H "X-Redline-Auth: ${REDLINE_API_KEY}") 
PASS=$(echo $RESULT | jq '.[0].success_rate >= '$SUCCESS_RATE' and .[0].avg_resp_time < '$RESPONSE_TIME)
RATE=$(echo $RESULT | jq '.[0].success_rate')
TIME=$(echo $RESULT | jq '.[0].avg_resp_time')
if [ $PASS != "true" ]; then
  echo "TEST DID NOT MEET REQUIREMENTS, FAIL - Check Load Test for detailed results"
  echo "Expecting SUCCESS RATE $SUCCESS_RATE ACTUAL $RATE"
  echo "Expecting RESPONSE TIME $RESPONSE_TIME ACTUAL $TIME"
  echo $RESULT | jq .[]
  exit 1
fi

echo "TEST PASSED RATE($RATE) RESPONSE TIME($TIME)"
## TODO show to access report data and check for specific endpoint metrics
