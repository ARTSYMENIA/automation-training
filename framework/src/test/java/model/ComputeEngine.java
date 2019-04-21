package model;

import java.util.Objects;

public class ComputeEngine {
    private String numberOfInstances;
    private String instancesFor;
    private String operatingSystem;
    private String VMClass;
    private String instanceType;
    private String AddGPUs;
    private String numberOfGPUs;
    private String GPUType;
    private String LocalSSD;
    private String DatacenterLocation;
    private String CommittedUsage;

    public ComputeEngine(String numberOfInstances, String instancesFor, String operatingSystem, String VMClass,
                         String instanceType, String addGPUs, String numberOfGPUs, String GPUType, String localSSD,
                         String datacenterLocation, String committedUsage) {
        this.numberOfInstances = numberOfInstances;
        this.instancesFor = instancesFor;
        this.operatingSystem = operatingSystem;
        this.VMClass = VMClass;
        this.instanceType = instanceType;
        this.AddGPUs = addGPUs;
        this.numberOfGPUs = numberOfGPUs;
        this.GPUType = GPUType;
        LocalSSD = localSSD;
        DatacenterLocation = datacenterLocation;
        CommittedUsage = committedUsage;
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

    public String getVMClass() {
        return VMClass;
    }

    public void setVMClass(String VMClass) {
        this.VMClass = VMClass;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    public String getAddGPUs() {
        return AddGPUs;
    }

    public void setAddGPUs(String addGPUs) {
        this.AddGPUs = addGPUs;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public void setNumberOfGPUs(String numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
    }

    public String getGPUType() {
        return GPUType;
    }

    public void setGPUType(String GPUType) {
        this.GPUType = GPUType;
    }

    public String getLocalSSD() {
        return LocalSSD;
    }

    public void setLocalSSD(String localSSD) {
        LocalSSD = localSSD;
    }

    public String getDatacenterLocation() {
        return DatacenterLocation;
    }

    public void setDatacenterLocation(String datacenterLocation) {
        DatacenterLocation = datacenterLocation;
    }

    public String getCommittedUsage() {
        return CommittedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        CommittedUsage = committedUsage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputeEngine that = (ComputeEngine) o;
        return AddGPUs == that.AddGPUs &&
                numberOfInstances.equals(that.numberOfInstances) &&
                Objects.equals(instancesFor, that.instancesFor) &&
                operatingSystem.equals(that.operatingSystem) &&
                VMClass.equals(that.VMClass) &&
                instanceType.equals(that.instanceType) &&
                numberOfGPUs.equals(that.numberOfGPUs) &&
                GPUType.equals(that.GPUType) &&
                LocalSSD.equals(that.LocalSSD) &&
                DatacenterLocation.equals(that.DatacenterLocation) &&
                CommittedUsage.equals(that.CommittedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, instancesFor, operatingSystem, VMClass, instanceType, AddGPUs,
                numberOfGPUs, GPUType, LocalSSD, DatacenterLocation, CommittedUsage);
    }

    @Override
    public String toString() {
        return "\n{" +
                "numberOfInstances='" + numberOfInstances + '\'' +
                ", instancesFor='" + instancesFor + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", VMClass='" + VMClass + '\'' +
                ", instanceType='" + instanceType + '\'' +
                ", AddGPUs='" + AddGPUs + '\'' +
                ", numberOfGPUs='" + numberOfGPUs + '\'' +
                ", GPUType='" + GPUType + '\'' +
                ", LocalSSD='" + LocalSSD + '\'' +
                ", DatacenterLocation='" + DatacenterLocation + '\'' +
                ", CommittedUsage='" + CommittedUsage + '\'' +
                '}';
    }
}
