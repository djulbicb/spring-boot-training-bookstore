package com.training.bookstore.context.tiles;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.definition.UnresolvingLocaleDefinitionsFactory;
import org.apache.tiles.definition.pattern.DefinitionPatternMatcherFactory;
import org.apache.tiles.definition.pattern.PatternDefinitionResolver;
import org.apache.tiles.definition.pattern.PrefixedPatternDefinitionResolver;
import org.apache.tiles.definition.pattern.regexp.RegexpDefinitionPatternMatcherFactory;
import org.apache.tiles.definition.pattern.wildcard.WildcardDefinitionPatternMatcherFactory;
import org.apache.tiles.evaluator.AttributeEvaluatorFactory;
import org.apache.tiles.extras.renderer.OptionsRenderer;
import org.apache.tiles.factory.BasicTilesContainerFactory;
import org.apache.tiles.locale.LocaleResolver;
import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.render.BasicRendererFactory;
import org.apache.tiles.request.render.Renderer;
import org.springframework.stereotype.Component;

@Component
public final class FinnTilesContainerFactory extends BasicTilesContainerFactory {
    @Override
    protected <T> PatternDefinitionResolver<T> createPatternDefinitionResolver(Class<T> customizationKeyClass) {
        PrefixedPatternDefinitionResolver<T> r = new PrefixedPatternDefinitionResolver<T>();
        r.registerDefinitionPatternMatcherFactory(
                "WILDCARD", new WildcardDefinitionPatternMatcherFactory());
        r.registerDefinitionPatternMatcherFactory(
                "REGEXP", new RegexpDefinitionPatternMatcherFactory());
        return r;
    }
    @Override
    protected Renderer createTemplateAttributeRenderer(BasicRendererFactory rendererFactory, ApplicationContext applicationContext, TilesContainer container, AttributeEvaluatorFactory attributeEvaluatorFactory) {
        Renderer original = super.createTemplateAttributeRenderer(rendererFactory, applicationContext, container, attributeEvaluatorFactory);
        OptionsRenderer optionsRenderer = new OptionsRenderer(applicationContext, original);
        return optionsRenderer;
    }


    @Override
    protected AttributeEvaluatorFactory createAttributeEvaluatorFactory(ApplicationContext applicationContext, LocaleResolver resolver) {
        return super.createAttributeEvaluatorFactory(applicationContext, resolver);
    }

    @Override
    protected UnresolvingLocaleDefinitionsFactory instantiateDefinitionsFactory(ApplicationContext applicationContext, LocaleResolver resolver) {
        return new FinnUnresolvingLocaleDefinitionsFactoryImpl();
    }
}