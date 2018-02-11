
echo curl https://www.redline13.com/Api/LoadTest \
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
  -F servers[0][usersPerServer]=1 

jq --help 

curl https://www.redline13.com/Api/LoadTest?loadTestId=55147 \
  -H "X-Redline-Auth: ${REDLINE_API_KEY}"

