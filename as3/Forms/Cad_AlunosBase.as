/**
 * Generated by Gas3 v3.0.0 (Granite Data Services).
 *
 * WARNING: DO NOT CHANGE THIS FILE. IT MAY BE OVERWRITTEN EACH TIME YOU USE
 * THE GENERATOR. INSTEAD, EDIT THE INHERITED CLASS (Cad_Alunos.as).
 */

package Forms {

    import flash.utils.IDataInput;
    import flash.utils.IDataOutput;
    import flash.utils.IExternalizable;
    import javax.swing.JFrame;
    import javax.swing.JTextField;

    [Bindable]
    public class Cad_AlunosBase implements IExternalizable {

        public function Cad_AlunosBase() {
        }

        private var _frmCadastroDeAluno:JFrame;
        private var _textBairro:JTextField;
        private var _textCelular:JTextField;
        private var _textCidade:JTextField;
        private var _textCod:JTextField;
        private var _textCpf:JTextField;
        private var _textDt_Nasc:JTextField;
        private var _textEmail:JTextField;
        private var _textEndereco:JTextField;
        private var _textNome:JTextField;
        private var _textNumero:JTextField;
        private var _textRg:JTextField;
        private var _textTelefone:JTextField;

        public function readExternal(input:IDataInput):void {
            _frmCadastroDeAluno = input.readObject() as JFrame;
            _textBairro = input.readObject() as JTextField;
            _textCelular = input.readObject() as JTextField;
            _textCidade = input.readObject() as JTextField;
            _textCod = input.readObject() as JTextField;
            _textCpf = input.readObject() as JTextField;
            _textDt_Nasc = input.readObject() as JTextField;
            _textEmail = input.readObject() as JTextField;
            _textEndereco = input.readObject() as JTextField;
            _textNome = input.readObject() as JTextField;
            _textNumero = input.readObject() as JTextField;
            _textRg = input.readObject() as JTextField;
            _textTelefone = input.readObject() as JTextField;
        }

        public function writeExternal(output:IDataOutput):void {
            output.writeObject(_frmCadastroDeAluno);
            output.writeObject(_textBairro);
            output.writeObject(_textCelular);
            output.writeObject(_textCidade);
            output.writeObject(_textCod);
            output.writeObject(_textCpf);
            output.writeObject(_textDt_Nasc);
            output.writeObject(_textEmail);
            output.writeObject(_textEndereco);
            output.writeObject(_textNome);
            output.writeObject(_textNumero);
            output.writeObject(_textRg);
            output.writeObject(_textTelefone);
        }
    }
}