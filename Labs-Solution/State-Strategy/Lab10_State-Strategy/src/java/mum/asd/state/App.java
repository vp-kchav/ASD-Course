/*
 * Created on Jan 23, 2018
 */
package mum.asd.state;


public class App {
    
    public static void main(String arg[]) {
        SimulateDriving simulateDrivingContext = new SimulateDriving();
        State regularState = new RegularState(simulateDrivingContext);
        State gravelState = new GravelState(simulateDrivingContext);
        State wetState = new WetState(simulateDrivingContext);
        State iceState = new IceState(simulateDrivingContext);
        simulateDrivingContext.setState(regularState);
        simulateDrivingContext.doLeft();
        simulateDrivingContext.doAccel();
        simulateDrivingContext.doRight();
        simulateDrivingContext.doBrake();
        simulateDrivingContext.setState(gravelState);
        simulateDrivingContext.doLeft();
        simulateDrivingContext.doAccel();
        simulateDrivingContext.doRight();
        simulateDrivingContext.doBrake();
        simulateDrivingContext.setState(wetState);
        simulateDrivingContext.doLeft();
        simulateDrivingContext.doAccel();
        simulateDrivingContext.doRight();
        simulateDrivingContext.doBrake();
        simulateDrivingContext.setState(iceState);
        simulateDrivingContext.doLeft();
        simulateDrivingContext.doAccel();
        simulateDrivingContext.doRight();
        simulateDrivingContext.doBrake();
    }
    

}
