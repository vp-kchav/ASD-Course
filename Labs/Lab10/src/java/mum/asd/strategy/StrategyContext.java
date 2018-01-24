/*
 * Created on Jan 23, 2018
 */
package mum.asd.strategy;

import java.util.List;

public class StrategyContext {
    
    private Model model;
    
    private static StrategyContext INSTANCE;
    
    public static StrategyContext getInstance(Model model) {
        if(INSTANCE == null) 
            return new StrategyContext(model);
        return INSTANCE;
    }
    
    private StrategyContext(Model model) {
        this.model = model;
    }
    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
    
    public int getRevenue(List<Flight> flights) {
        return model.getRevenue(flights);
    }

}
