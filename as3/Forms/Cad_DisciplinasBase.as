/**
 * Generated by Gas3 v3.0.0 (Granite Data Services).
 *
 * WARNING: DO NOT CHANGE THIS FILE. IT MAY BE OVERWRITTEN EACH TIME YOU USE
 * THE GENERATOR. INSTEAD, EDIT THE INHERITED CLASS (Cad_Disciplinas.as).
 */

package Forms {

    import flash.utils.IDataInput;
    import flash.utils.IDataOutput;
    import flash.utils.IExternalizable;
    import javax.swing.JFrame;
    import javax.swing.JTextField;

    [Bindable]
    public class Cad_DisciplinasBase implements IExternalizable {

        public function Cad_DisciplinasBase() {
        }

        private var _Cad_Disciplinas:JFrame;
        private var _descricao:JTextField;
        private var _textCodigo:JTextField;

        public function readExternal(input:IDataInput):void {
            _Cad_Disciplinas = input.readObject() as JFrame;
            _descricao = input.readObject() as JTextField;
            _textCodigo = input.readObject() as JTextField;
        }

        public function writeExternal(output:IDataOutput):void {
            output.writeObject(_Cad_Disciplinas);
            output.writeObject(_descricao);
            output.writeObject(_textCodigo);
        }
    }
}