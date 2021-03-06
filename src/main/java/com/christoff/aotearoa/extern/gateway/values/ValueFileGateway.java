package com.christoff.aotearoa.extern.gateway.values;

import com.christoff.aotearoa.extern.gateway.FileYamlHelper;
import com.christoff.aotearoa.intern.gateway.metadata.Metadata;
import com.christoff.aotearoa.intern.gateway.metadata.MetadataIOException;
import com.christoff.aotearoa.intern.gateway.metadata.MetadataValidator;
import com.christoff.aotearoa.intern.gateway.values.IValueGateway;
import com.christoff.aotearoa.intern.gateway.values.ValueException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ValueFileGateway implements IValueGateway
{
    private Map<String,Object> _valueMap;
    private FileYamlHelper _yamlHelper;

    public ValueFileGateway(String valueFile) {

        _yamlHelper = new FileYamlHelper();
        try {
            _valueMap = _yamlHelper.loadYaml(valueFile);
        } catch (IOException e) {
            throw new MetadataIOException(e.getMessage());
        }
    }

    @Override
    public void setMetadata(Map<String, Metadata> allVarMetadata) {}

    @Override
    public List<Object> get(Metadata vm)
    {
        if(!(_valueMap.get(vm.getName()) instanceof List))
            throw new ValueException("No values found for metadata tag " + vm.getName());
        
        return (List<Object>) _valueMap.get(vm.getName());
    }
}
