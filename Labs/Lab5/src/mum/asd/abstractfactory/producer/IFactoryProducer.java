/*
 * Created on Jan 18, 2018
 */
package mum.asd.abstractfactory.producer;

import mum.asd.abstractfactory.PackagingFactory;
import mum.asd.abstractfactory.type.PackType;

public interface IFactoryProducer {
    public PackagingFactory getFactory(PackType packType);
    
}
