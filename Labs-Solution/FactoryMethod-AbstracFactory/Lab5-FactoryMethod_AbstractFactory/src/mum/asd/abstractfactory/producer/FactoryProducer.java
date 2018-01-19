/*
 * Created on Jan 18, 2018
 */
package mum.asd.abstractfactory.producer;

import mum.asd.abstractfactory.AdultFactory;
import mum.asd.abstractfactory.BusinessFactory;
import mum.asd.abstractfactory.KidFactory;
import mum.asd.abstractfactory.PackagingFactory;
import mum.asd.abstractfactory.type.PackType;

public class FactoryProducer implements IFactoryProducer {
    public static FactoryProducer INSTANCE;
    private FactoryProducer() {
        
    }
    
    public static FactoryProducer getInstance() {
        if(INSTANCE == null)
            INSTANCE = new FactoryProducer();
        return INSTANCE;
    }

    @Override
    public PackagingFactory getFactory(PackType packType) {
        switch (packType) {
            case Business:
                return new BusinessFactory();
            case Adults:
                return new AdultFactory();
            case Kids:
                return new KidFactory();
            default:
                return null;
        }
    }
}
