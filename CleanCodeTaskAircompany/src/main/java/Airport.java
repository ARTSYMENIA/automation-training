// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

import planes.ExperimentalPlane;
import models.MilitaryTypes;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;
import java.util.*;
import java.util.function.ToIntFunction;

public class Airport {
    private List<? extends Plane> planes;

    Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    List<? extends Plane> getPlanes() {
        return planes;
    }

    List<PassengerPlane> getPassengerPlanes() {
        List<PassengerPlane> passengerPlanes = new ArrayList<>();
        for (Plane planeSample : planes) {
            if (planeSample instanceof PassengerPlane) {
                passengerPlanes.add((PassengerPlane) planeSample);
            }
        }
        return passengerPlanes;
    }

    List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane planeSample : planes) {
            if (planeSample instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) planeSample);
            }
        }
        return militaryPlanes;
    }

    List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane planeSample : planes) {
            if (planeSample instanceof ExperimentalPlane) {
                experimentalPlanes.add((ExperimentalPlane) planeSample);
            }
        }
        return experimentalPlanes;
    }

    PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlanes();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (PassengerPlane passengerPlaneSample : passengerPlanes) {
            if (passengerPlaneSample.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlaneSample;
            }
        }
        return planeWithMaxCapacity;
    }

    List<MilitaryPlane> getTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (MilitaryPlane militaryPlaneSample : militaryPlanes) {
            if (militaryPlaneSample.getType() == MilitaryTypes.TRANSPORT) {
                transportMilitaryPlanes.add(militaryPlaneSample);
            }
        }
        return transportMilitaryPlanes;
    }

    List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (MilitaryPlane militaryPlaneSample : militaryPlanes) {
            if (militaryPlaneSample.getType() == MilitaryTypes.BOMBER) {
                bomberMilitaryPlanes.add(militaryPlaneSample);
            }
        }
        return bomberMilitaryPlanes;
    }

    Airport sortByMaxDistance() {
        planes.sort(Comparator.comparingInt((ToIntFunction<Plane>) Plane::getMaxFlightDistance));
        return this;
    }

    Airport sortByMaxSpeed() {
        planes.sort(Comparator.comparingInt((ToIntFunction<Plane>) Plane::getMaxSpeed));
        return this;
    }

    void sortByMaxLoadCapacity() {
        planes.sort(Comparator.comparingInt((ToIntFunction<Plane>) Plane::getMaxLoadCapacity));
    }

    @Override
    public String toString() {
        return "Airport" +
                "planes=" + planes.toString() +
                '}';
    }

}
