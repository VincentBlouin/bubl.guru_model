/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model.forgot_password.email;

import java.util.ListResourceBundle;

public class ForgotPasswordResourceBundle_fr extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return contents;
    }
    static final Object[][] contents = {
            {"body", "Suivez ce lien pour mettre à jour votre mot de passe"}
    };
}
