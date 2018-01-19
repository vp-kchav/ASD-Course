/*
 * Created on Jan 18, 2018
 */
package mum.asd.abstractfactory;

import mum.asd.abstractfactory.packaging.EverydayValue;
import mum.asd.abstractfactory.packaging.Packaging;
import mum.asd.abstractfactory.packaging.PlainPaper;
import mum.asd.abstractfactory.packaging.ReusableShopper;
import mum.asd.abstractfactory.type.PackagingType;

public class AdultFactory extends PackagingFactory {

    @Override
    public Packaging getPackaing(PackagingType packType) {
        switch (packType) {
            case Bag:
                return new ReusableShopper();
            case Box:
                return new PlainPaper();
            case Wrap:
                return new EverydayValue();
            default: 
                return null;
        }
    }

}
