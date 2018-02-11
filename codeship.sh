curl https://www.redline13.com/Api/LoadTest \
  -H "X-Redline-Auth: ${REDLINE_API_KEY}" \
  -F testType=jmeter-test \
  -F name=CodeShipAndRedLine13 \
  -F "file=@/Users/rfriedman/jenkins-pipeline/tests/Plexify.jmx" \
  -F numServers=2 \
  -F storeOutput=T \
  -F servers[0][location]=us-east-1 \
  -F servers[0][size]=m3.medium \
  -F servers[0][num]=2 \
  -F servers[0][onDemand]=T \
  -F servers[0][usersPerServer]=1

