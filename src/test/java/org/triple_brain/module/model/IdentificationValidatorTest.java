package org.triple_brain.module.model;

import com.google.gson.Gson;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;
import org.triple_brain.module.model.graph.FriendlyResourcePojo;
import org.triple_brain.module.model.graph.Identification;
import org.triple_brain.module.model.graph.IdentificationPojo;
import org.triple_brain.module.model.validator.IdentificationValidator;

import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*
* Copyright Mozilla Public License 1.1
*/
public class IdentificationValidatorTest {

    private Gson gson = new Gson();

    private enum fields{
        externalResourceUri
    }

    @Test
    public void no_errors_when_external_uri_is_present()throws Exception{
        JSONObject friendlyResource = new JSONObject().put(
                fields.externalResourceUri.name(),
                "http://triple-brain.org/asviojasoviasjvoisjv"
        );
        assertFalse(validationWithJsonReturnsMessage(
                friendlyResource,
                IdentificationValidator.IdentificationError.EXTERNAL_URI_MANDATORY
        ));
    }

    @Test
    public void external_resource_uri_is_mandatory(){
        assertTrue(validationWithJsonReturnsMessage(
                new JSONObject(),
                IdentificationValidator.IdentificationError.EXTERNAL_URI_MANDATORY
        ));
    }

    @Test
    public void uri_has_to_be_valid()throws Exception{
        JSONObject friendlyResource = new JSONObject()
                .put(
                        fields.externalResourceUri.name(),
                        ""
                );
        assertTrue(validationWithJsonReturnsMessage(
                friendlyResource,
                IdentificationValidator.IdentificationError.EMPTY_EXTERNAL_URI
        ));
    }

    @Test
    public void can_have_relative_uris()throws Exception{
        JSONObject json = new JSONObject()
                .put(
                        fields.externalResourceUri.name(),
                        "/service/users/vince/graph/edge/c30bbev5-0c1f-4b08-b600-fb6040abb7eq/identification"
                );
        IdentificationValidator validator = new IdentificationValidator();
        Identification identification = gson.fromJson(
                json.toString(),
                IdentificationPojo.class
        );
        assertTrue(
                validator.validate(
                        identification
                ).isEmpty()
        );
    }

    private boolean validationWithJsonReturnsMessage(
            JSONObject json,
            IdentificationValidator.IdentificationError message
    ){
        Set<IdentificationValidator.IdentificationError> errors ;
        errors = new IdentificationValidator().validate(
                identificationFromJson(json)
        );
        return errors.contains(message);
    }

    private Identification identificationFromJson(JSONObject jsonObject){
        return gson.fromJson(
                jsonObject.toString(),
                IdentificationPojo.class
        );
    }
}