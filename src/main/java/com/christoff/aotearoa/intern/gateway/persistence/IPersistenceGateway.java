package com.christoff.aotearoa.intern.gateway.persistence;

import com.christoff.aotearoa.intern.gateway.metadata.Metadata;
import java.util.Map;

public interface IPersistenceGateway
{
    void persistValues(TemplateResolverFunction resolver, Map<String, Metadata> allVarMetadata);
}
