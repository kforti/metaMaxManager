/**
 * This example plugin pops up a dialog box that says "Hello, world!".
 * 
 * Copyright University of California
 * 
 * LICENSE:      This file is distributed under the BSD license.
 *               License text is included with the source distribution.
 *
 *               This file is distributed in the hope that it will be useful,
 *               but WITHOUT ANY WARRANTY; without even the implied warranty
 *               of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 *               IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 *               CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 *               INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES.
 */

package org.micromanager.metamaxmanager;

import ij.gui.GUI;
import mmcorej.CMMCore;

import org.micromanager.api.MMPlugin;
import org.micromanager.api.ScriptInterface;
import org.micromanager.metamaxmanager.model.Model;
import org.micromanager.metamaxmanager.view.MetaMaxView;


public class HelloWorldPlugin implements MMPlugin {
   public static final String menuName = "Meta Max";
   public static final String tooltipDescription =
      "Displays a simple dialog";
   private GUI user;

   // Provides access to the Micro-Manager Java API (for GUI control and high-
   // level functions).
   private ScriptInterface app_;
   // Provides access to the Micro-Manager Core API (for direct hardware
   // control)
   private CMMCore core_;

   Model model_;

   public static void main(){
      return;
   }

   @Override
   public void setApp(ScriptInterface app) {
      app_ = app;
      core_ = app.getMMCore();
      model_ = new Model();
      MetaMaxView view = new MetaMaxView(model_, core_);
      app_.addMMBackgroundListener(view);
      app_.addMMListener(view);
      view.start();

   }

   @Override
   public void dispose() {
      // We do nothing here as the only object we create, our dialog, should
      // be dismissed by the user.
   }

   @Override
   public void show() {
//      JOptionPane.showMessageDialog(null, "Hello, world!", "Hello world!",
//            JOptionPane.PLAIN_MESSAGE);
      String ig = "Meta Max";
   }
   
   @Override
   public String getInfo () {
      return "Displays a simple greeting.";
   }

   @Override
   public String getDescription() {
      return tooltipDescription;
   }
   
   @Override
   public String getVersion() {
      return "1.0";
   }
   
   @Override
   public String getCopyright() {
      return "University of California, 2015";
   }
}
