package com.adobe.aem.guides.wknd.core.configurations;


import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "HTTP Search Configuration", description = "Config for search component")
public @interface SearchConfiguration {

    @AttributeDefinition(
            name = "Enable config",
            description = "This property indicates whether the configuration values will taken into account or not",
            type = AttributeType.BOOLEAN)
    public boolean enableConfig() default true;

    @AttributeDefinition(
            name = "Path",
            description = "Enter root the path")
    public String getRootPath();
}
