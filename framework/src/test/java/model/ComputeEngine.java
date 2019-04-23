package model;

import java.util.Objects;

public class ComputeEngine {
    private String numberOfInstances;
    private String instancesFor;
    private String operatingSystem;
    private String vmClass;
    private String instanceType;
    private String addGPUs;
    private String numberOfGPUs;
    private String gpuType;
    private String localSSD;
    private String datacenterLocation;
    private String committedUsage;

    public ComputeEngine(String numberOfInstances, String instancesFor, String operatingSystem, String vmClass,
                         String instanceType, String addGPUs, String numberOfGPUs, String gpuType, String localSSD,
                         String datacenterLocation, String committedUsage) {
        this.numberOfInstances = numberOfInstances;
        this.instancesFor = instancesFor;
        this.operatingSystem = operatingSystem;
        this.vmClass = vmClass;
        this.instanceType = instanceType;
        this.addGPUs = addGPUs;
        this.numberOfGPUs = numberOfGPUs;
        this.gpuType = gpuType;
        this.localSSD = localSSD;
        this.datacenterLocation = datacenterLocation;
        this.committedUsage = committedUsage;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getInstancesFor() {
        return instancesFor;
    }

    public void setInstancesFor(String instancesFor) {
        this.instancesFor = instancesFor;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getVmClass() {
        return vmClass;
    }

    public void setVmClass(String vmClass) {
        this.vmClass = vmClass;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    public String getAddGPUs() {
        return addGPUs;
    }

    public void setAddGPUs(String addGPUs) {
        this.addGPUs = addGPUs;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public void setNumberOfGPUs(String numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
    }

    public String getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public void setDatacenterLocation(String datacenterLocation) {
        this.datacenterLocation = datacenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputeEngine that = (ComputeEngine) o;
        return numberOfInstances.equals(that.numberOfInstances) &&
                Objects.equals(instancesFor, that.instancesFor) &&
                operatingSystem.equals(that.operatingSystem) &&
                vmClass.equals(that.vmClass) &&
                instanceType.equals(that.instanceType) &&
                Objects.equals(addGPUs, that.addGPUs) &&
                numberOfGPUs.equals(that.numberOfGPUs) &&
                gpuType.equals(that.gpuType) &&
                localSSD.equals(that.localSSD) &&
                datacenterLocation.equals(that.datacenterLocation) &&
                committedUsage.equals(that.committedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, instancesFor, operatingSystem, vmClass, instanceType, addGPUs,
                numberOfGPUs, gpuType, localSSD, datacenterLocation, committedUsage);
    }

    @Override
    public String toString() {
        return "\n{" +
                "numberOfInstances='" + numberOfInstances + '\'' +
                ", instancesFor='" + instancesFor + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", vmClass='" + vmClass + '\'' +
                ", instanceType='" + instanceType + '\'' +
                ", addGPUs='" + addGPUs + '\'' +
                ", numberOfGPUs='" + numberOfGPUs + '\'' +
                ", gpuType='" + gpuType + '\'' +
                ", localSSD='" + localSSD + '\'' +
                ", datacenterLocation='" + datacenterLocation + '\'' +
                ", committedUsage='" + committedUsage + '\'' +
                '}';
    }
}
