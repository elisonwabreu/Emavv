/**
 * Generated by Gas3 v3.0.0 (Granite Data Services).
 *
 * WARNING: DO NOT CHANGE THIS FILE. IT MAY BE OVERWRITTEN EACH TIME YOU USE
 * THE GENERATOR. INSTEAD, EDIT THE INHERITED CLASS (Matriculados.as).
 */

package Classes {

    import flash.utils.IDataInput;
    import flash.utils.IDataOutput;

    [Bindable]
    public class MatriculadosBase extends Matriculas {

        public function MatriculadosBase() {
            super();
        }

        public var _curso:int;

        public function set curso(value:int):void {
            _curso = value;
        }
        public function get curso():int {
            return _curso;
        }

        public override function readExternal(input:IDataInput):void {
            super.readExternal(input);
            _curso = input.readObject() as int;
        }

        public override function writeExternal(output:IDataOutput):void {
            super.writeExternal(output);
            output.writeObject(_curso);
        }
    }
}