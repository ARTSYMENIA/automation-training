package service;

import model.ComputeEngine;

public class ComputeEngineCreator {
    private static final String TESTDATA_ENGINE_INSTANCES = "testdata.engine.instances";
    private static final String TESTDATA_ENGINE_INSTANCES_FOR = "testdata.engine.instancesfor";
    private static final String TESTDATA_ENGINE_OPERATING_SYSTEM = "testdata.engine.system";
    private static final String TESTDATA_ENGINE_VM_CLASS = "testdata.engine.vmclass";
    private static final String TESTDATA_ENGINE_INSTANCE_TYPE = "testdata.engine.instancetype";
    private static final String TESTDATA_ENGINE_ADD_GPUS = "testdata.engine.addgpus";
    private static final String TESTDATA_ENGINE_NUMBER_OF_GPUS = "testdata.engine.numberofgpus";
    private static final String TESTDATA_ENGINE_GPU_TYPE = "testdata.engine.gputype";
    private static final String TESTDATA_ENGINE_LOCAL_SSD = "testdata.engine.ssd";
    private static final String TESTDATA_ENGINE_DATACENTER_LOCATION = "testdata.engine.location";
    private static final String TESTDATA_ENGINE_COMMITTED_USAGE = "testdata.engine.usage";

    public static ComputeEngine computeEngineForEstimating() {
        return new ComputeEngine(Integer.parseInt(TestDataReader.getTestData(TESTDATA_ENGINE_INSTANCES)),
                TestDataReader.getTestData(TESTDATA_ENGINE_INSTANCES_FOR),
                TestDataReader.getTestData(TESTDATA_ENGINE_OPERATING_SYSTEM),
                TestDataReader.getTestData(TESTDATA_ENGINE_VM_CLASS),
                TestDataReader.getTestData(TESTDATA_ENGINE_INSTANCE_TYPE),
                Boolean.parseBoolean(TestDataReader.getTestData(TESTDATA_ENGINE_ADD_GPUS)),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_ENGINE_NUMBER_OF_GPUS)),
                TestDataReader.getTestData(TESTDATA_ENGINE_GPU_TYPE),
                TestDataReader.getTestData(TESTDATA_ENGINE_LOCAL_SSD),
                TestDataReader.getTestData(TESTDATA_ENGINE_DATACENTER_LOCATION),
                TestDataReader.getTestData(TESTDATA_ENGINE_COMMITTED_USAGE));
    }
}
