/**
 * Generated by Gas3 v3.0.0 (Granite Data Services).
 *
 * WARNING: DO NOT CHANGE THIS FILE. IT MAY BE OVERWRITTEN EACH TIME YOU USE
 * THE GENERATOR. INSTEAD, EDIT THE INHERITED CLASS (TelaLogin.as).
 */

package Forms {

    import Daos.DaoUsuarios;
    import Messages.Cmessage;
    import flash.utils.IDataInput;
    import flash.utils.IDataOutput;
    import flash.utils.IExternalizable;
    import java.awt.Panel;
    import javax.swing.JFrame;
    import javax.swing.JPasswordField;
    import javax.swing.JTextField;

    [Bindable]
    public class TelaLoginBase implements IExternalizable {

        public function TelaLoginBase() {
        }

        protected var _a:Cmessage;
        private var _frmEmavv:JFrame;
        private var _login:JTextField;
        protected var _novo:DaoUsuarios;
        private var _panel:Panel;
        private var _senha:JPasswordField;

        public function readExternal(input:IDataInput):void {
            _a = input.readObject() as Cmessage;
            _frmEmavv = input.readObject() as JFrame;
            _login = input.readObject() as JTextField;
            _novo = input.readObject() as DaoUsuarios;
            _panel = input.readObject() as Panel;
            _senha = input.readObject() as JPasswordField;
        }

        public function writeExternal(output:IDataOutput):void {
            output.writeObject(_a);
            output.writeObject(_frmEmavv);
            output.writeObject(_login);
            output.writeObject(_novo);
            output.writeObject(_panel);
            output.writeObject(_senha);
        }
    }
}