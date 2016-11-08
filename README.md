# Example for Jenkins Pipeline with RedLine13 Plugin

as- redlineJMeter - Executes a JMeter test
- redlineGatling - Executes a Gatling test
- redlineCustom - Executes a custom PHP, Python, NodeJS tests
- redlineScenario - Executes an existing template already on RedLine13

All tests are configured with 4 sets of parametersddddd

## Generic 
- name - name of load tests
- desc - optional descriptoin
- storeOutput - if result files should be stored
```
            name: 'MyHotTest', 
            desc: 'Started from the pipeline project', 
            storeOutput: true,
```

## Test Specific
See the snippet generator for each test type, they each have custom parameters
- Files are relative to the workspace, which will usually be the root of your SCM checkout.

### JMeter
```
            masterFile: 'Test Plan WordPress.jmx' , 
            version: '3.0',
            opts: '',
            jvm_args: '',
            extraFiles: [  [extraFile: 'my.csv'], [extraFile: 'or-some.list']]
```

### Gatling
```
            masterFile: 'Test Plan WordPress.jmx' , 
            version: '2.2.0',
            opts: '',
            jvm_args: '',
            extraFiles: [  [extraFile: 'my.csv'], [extraFile: 'or-some.list']]
```

### Custom
```
            masterFile: 'myCustomTest.js',
            language: 'nodejs'
```

### Scenario
```
            templateId: ''
```

## Cloud Settings
Defines the cloud configuration for the tests, defined as array of Servers
- These are not used for Scenario tests, those are predefined on RedLine13.com
- Custom tests have an extra server parameter usersPerServer to define # of users to simulate on a test server.
- Cloud settings are detailed at https://www.redline13.com/ApiDoc/LoadTest/Post#cloud
```
            servers: 
            [
                [
                    location: 'us-east-1', 
                    numberServers: 1,
                    size: 'm3.medium', 
                    subnetId: '', 
                    securityGroupIds: '', 
                    useSpot: false, 
                    volumeSize: 8,
                    associatePublicIpAddress: true
                ]
            ]
```

## Thresholds
Define the thresholds to use for marking build failed or unstable.
```
            thresholds: 
            [
                errorFailedThreshold: 0, 
                errorUnstableThreshold: 0, 
                responseTimeFailedThreshold: 0, 
                responseTimeUnstableThreshold: 0
            ]
```
