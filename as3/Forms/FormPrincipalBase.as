/**
 * Generated by Gas3 v3.0.0 (Granite Data Services).
 *
 * WARNING: DO NOT CHANGE THIS FILE. IT MAY BE OVERWRITTEN EACH TIME YOU USE
 * THE GENERATOR. INSTEAD, EDIT THE INHERITED CLASS (FormPrincipal.as).
 */

package Forms {

    import flash.utils.IDataInput;
    import flash.utils.IDataOutput;
    import flash.utils.IExternalizable;
    import javax.swing.JFrame;

    [Bindable]
    public class FormPrincipalBase implements IExternalizable {

        public function FormPrincipalBase() {
        }

        private var _frmMenu:JFrame;

        public function readExternal(input:IDataInput):void {
            _frmMenu = input.readObject() as JFrame;
        }

        public function writeExternal(output:IDataOutput):void {
            output.writeObject(_frmMenu);
        }
    }
}