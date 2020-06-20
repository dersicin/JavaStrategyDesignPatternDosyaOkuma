/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategytasarimdosyaokuma;

//Strategy sınıfını tutacak sınıfımız
public class Context {
    private Strategy strategy;
    
    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }
    
    public void dosya_oku(String filePath, StrategyTasarimDosyaOkuma stdo){
        strategy.oku(filePath,stdo);
    }
}
