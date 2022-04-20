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
    public boolean enableConfig();

    @AttributeDefinition(
            name = "Path",
            description = "Enter the path")
    public String getPath();

    @AttributeDefinition(
            name = "Endpoint",
            description = "Enter the endpoint")
     public String getEndpoint();

}
