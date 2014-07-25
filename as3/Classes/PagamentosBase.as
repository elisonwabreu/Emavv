/**
 * Generated by Gas3 v3.0.0 (Granite Data Services).
 *
 * WARNING: DO NOT CHANGE THIS FILE. IT MAY BE OVERWRITTEN EACH TIME YOU USE
 * THE GENERATOR. INSTEAD, EDIT THE INHERITED CLASS (Pagamentos.as).
 */

package Classes {

    import flash.utils.IDataInput;
    import flash.utils.IDataOutput;
    import flash.utils.IExternalizable;
    import javax.xml.crypto.Data;

    [Bindable]
    public class PagamentosBase implements IExternalizable {

        public function PagamentosBase() {
        }

        private var _dataPagamento:Data;
        private var _despesa:int;
        private var _observacao:String;
        private var _valor:Number;

        public function set dataPagamento(value:Data):void {
            _dataPagamento = value;
        }
        public function get dataPagamento():Data {
            return _dataPagamento;
        }

        public function set despesa(value:int):void {
            _despesa = value;
        }
        public function get despesa():int {
            return _despesa;
        }

        public function set observacao(value:String):void {
            _observacao = value;
        }
        public function get observacao():String {
            return _observacao;
        }

        public function set valor(value:Number):void {
            _valor = value;
        }
        public function get valor():Number {
            return _valor;
        }

        public function readExternal(input:IDataInput):void {
            _dataPagamento = input.readObject() as Data;
            _despesa = input.readObject() as int;
            _observacao = input.readObject() as String;
            _valor = function(o:*):Number { return (o is Number ? o as Number : Number.NaN) } (input.readObject());
        }

        public function writeExternal(output:IDataOutput):void {
            output.writeObject(_dataPagamento);
            output.writeObject(_despesa);
            output.writeObject(_observacao);
            output.writeObject(_valor);
        }
    }
}