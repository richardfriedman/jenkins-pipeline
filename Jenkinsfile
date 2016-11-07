node {

    stage('source') {
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/richardfriedman/jenkins-pipeline.git']]])
    }
    
    stage('deploy') {
        echo 'Deploy test or staging environments.'
    }

    stage('perftest') {
        RedlineJMeter( 
            name: 'HotPipe', 
            desc: 'Started from the pipeline project', 
            storeOutput: true,
            jmeterFile: 'Test Plan WordPress.jmx' , 
            jmeterVersion: '3.0', 
            jvmArgs: '', 
            opts: '-Jserver_name=www.runsignup.com -Jloop_count=5 -Jusers=10', 
            servers: 
            [
                [
                    associatePublicIpAddress: true, 
                    location: 'us-west-2', 
                    numberServers: 1, 
                    securityGroupIds: '', 
                    size: 'm3.medium', 
                    subnetId: '', 
                    useSpot: false, 
                    volumeSize: 8
                ]
            ] 
        )
    }
}
