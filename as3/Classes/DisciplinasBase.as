/**
 * Generated by Gas3 v3.0.0 (Granite Data Services).
 *
 * WARNING: DO NOT CHANGE THIS FILE. IT MAY BE OVERWRITTEN EACH TIME YOU USE
 * THE GENERATOR. INSTEAD, EDIT THE INHERITED CLASS (Disciplinas.as).
 */

package Classes {

    import flash.utils.IDataInput;
    import flash.utils.IDataOutput;
    import flash.utils.IExternalizable;

    [Bindable]
    public class DisciplinasBase implements IExternalizable {

        public function DisciplinasBase() {
        }

        public var _descricao:String;
        public var _status:String;

        public function set descricao(value:String):void {
            _descricao = value;
        }
        public function get descricao():String {
            return _descricao;
        }

        public function set status(value:String):void {
            _status = value;
        }
        public function get status():String {
            return _status;
        }

        public function readExternal(input:IDataInput):void {
            _descricao = input.readObject() as String;
            _status = input.readObject() as String;
        }

        public function writeExternal(output:IDataOutput):void {
            output.writeObject(_descricao);
            output.writeObject(_status);
        }
    }
}