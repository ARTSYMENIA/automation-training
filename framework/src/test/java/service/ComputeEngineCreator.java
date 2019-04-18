package service;

import model.ComputeEngine;

public class ComputeEngineCreator {
    public static final String TESTDATA_ENGINE_INSTANCES = "testdata.engine.instances";
    public static final String TESTDATA_ENGINE_INSTANCES_FOR = "testdata.engine.instancesfor";
    public static final String TESTDATA_ENGINE_OPERATING_SYSTEM = "testdata.engine.system";
    public static final String TESTDATA_ENGINE_VM_CLASS = "testdata.engine.vmclass";
    public static final String TESTDATA_ENGINE_INSTANCE_TYPE = "testdata.engine.instancetype";
    public static final String  TESTDATA_ENGINE_ADD_GPUS = "testdata.engine.addgpus";
    public static final String TESTDATA_ENGINE_NUMBER_OF_GPUS = "testdata.engine.numberofgpus";
    public static final String TESTDATA_ENGINE_GPU_TYPE = "testdata.engine.gputype";
    public static final String TESTDATA_ENGINE_LOCAL_SSD = "testdata.engine.localssd";
    public static final String TESTDATA_ENGINE_DATACENTER_LOCATION = "testdata.engine.datacenterlocation";
    public static final String TESTDATA_ENGINE_COMMITTED_USAGE = "testdata.engine.committedusage";

    public static ComputeEngine computeEngineForEstimating() {
        return new ComputeEngine(TestDataReader.getTestData(TESTDATA_ENGINE_INSTANCES),
                TestDataReader.getTestData(TESTDATA_ENGINE_INSTANCES_FOR),
                TestDataReader.getTestData(TESTDATA_ENGINE_OPERATING_SYSTEM),
                TestDataReader.getTestData(TESTDATA_ENGINE_VM_CLASS),
                TestDataReader.getTestData(TESTDATA_ENGINE_INSTANCE_TYPE),
                TestDataReader.getTestData(TESTDATA_ENGINE_ADD_GPUS),
                TestDataReader.getTestData(TESTDATA_ENGINE_NUMBER_OF_GPUS),
                TestDataReader.getTestData(TESTDATA_ENGINE_GPU_TYPE),
                TestDataReader.getTestData(TESTDATA_ENGINE_LOCAL_SSD),
                TestDataReader.getTestData(TESTDATA_ENGINE_DATACENTER_LOCATION),
                TestDataReader.getTestData(TESTDATA_ENGINE_COMMITTED_USAGE));
    }
}
