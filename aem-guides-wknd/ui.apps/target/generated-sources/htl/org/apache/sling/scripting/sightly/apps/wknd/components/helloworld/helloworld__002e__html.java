/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 ******************************************************************************/
package org.apache.sling.scripting.sightly.apps.wknd.components.helloworld;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class helloworld__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_model = null;
Object _dynamic_properties = bindings.get("properties");
out.write("\n");
_global_model = renderContext.call("use", com.adobe.aem.guides.wknd.core.models.HelloWorldModel.class.getName(), obj());
out.write("<div class=\"cmp-helloworld\" data-cmp-is=\"helloworld\">\n    <h1 class=\"cmp-helloworld__title\">");
{
    Object var_0 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_model, "title"), "text");
    out.write(renderContext.getObjectModel().toString(var_0));
}
out.write("</h1>\n    ");
{
    Object var_testvariable1 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "text");
    if (renderContext.getObjectModel().toBoolean(var_testvariable1)) {
        out.write("<div class=\"cmp-helloworld__item\">\n        <p class=\"cmp-helloworld__item-label\">Text property:</p>\n        <pre class=\"cmp-helloworld__item-output\" data-cmp-hook-helloworld=\"property\">");
        {
            Object var_2 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "text"), "text");
            out.write(renderContext.getObjectModel().toString(var_2));
        }
        out.write("</pre>\n    </div>");
    }
}
out.write("\n    ");
{
    Object var_testvariable3 = renderContext.getObjectModel().resolveProperty(_global_model, "text");
    if (renderContext.getObjectModel().toBoolean(var_testvariable3)) {
        out.write("<div class=\"cmp-helloworld__item\">\n    <p class=\"cmp-helloworld__item-label\">Sling Model getText() property:</p>\n    <pre class=\"cmp-helloworld__item-output\" data-cmp-hook-helloworld=\"property\">");
        {
            Object var_4 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_model, "text"), "text");
            out.write(renderContext.getObjectModel().toString(var_4));
        }
        out.write("</pre>\n</div>");
    }
}
out.write("\n    ");
{
    Object var_testvariable5 = renderContext.getObjectModel().resolveProperty(_global_model, "message");
    if (renderContext.getObjectModel().toBoolean(var_testvariable5)) {
        out.write("<div class=\"cmp-helloworld__item\">\n        <p class=\"cmp-helloworld__item-label\">Model message:</p>\n        <pre class=\"cmp-helloworld__item-output\" data-cmp-hook-helloworld=\"model\">");
        {
            Object var_6 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_model, "message"), "text");
            out.write(renderContext.getObjectModel().toString(var_6));
        }
        out.write("</pre>\n    </div>");
    }
}
out.write("\n</div>\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

