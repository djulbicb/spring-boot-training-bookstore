package com.training.bookstore.config.themes;

import org.apache.tiles.Attribute;
import org.apache.tiles.Definition;
import org.apache.tiles.ListAttribute;
import org.apache.tiles.definition.UnresolvingLocaleDefinitionsFactory;
import org.apache.tiles.request.Request;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TilesUnresolvingDefinitionsFactoryImpl extends UnresolvingLocaleDefinitionsFactory {
    private static final String DEF_INJECTION = "definition-injection";

    @Override
    public Definition getDefinition(String name, Request tilesContext) {
        Definition def = null;
        // WEB-INF is a pretty clear indicator it is not a definition

        def = super.getDefinition(name, tilesContext);
        if(null != def){
            def = new Definition(def); // use a safe copy
            Attribute defList = def.getLocalAttribute(DEF_INJECTION); // explicit injected definitions
            if(null != defList && defList instanceof ListAttribute){
                for(Attribute inject : (List<Attribute>) defList.getValue()){
                    injectDefinition((String) inject.getValue(), def, tilesContext);
                }
            }
        }

        return def;
    }


    private void injectDefinition(String fromName, Definition to, Request cxt) {
        assert null != fromName : "Definition not found " + fromName;
        Definition from = getDefinition(fromName, cxt);
        if (null != from) {
            if (null != from.getLocalAttributeNames()) {
                for (String attrName : from.getLocalAttributeNames()) {
                    to.putAttribute(attrName, from.getLocalAttribute(attrName), true);
                }
            }
        }
    }

}