package com.example.cronometrocubosbandeco;

public class Cube5x5 {

    private long _id;
    private String tempo5x5;

    public Cube5x5(long _id, String tempo5x5){
        this._id = _id;
        this.tempo5x5 = tempo5x5;
    }

    public long get_id(){return _id; }
    public void set_id(long _id){this._id = _id; }
    public String getTempo5x5() {return tempo5x5; }
    public void setTempo5x5(String tempo) {this.tempo5x5 = tempo; }

    @Override
    public String toString(){
        return "\n" + "Tempo "+"\n"+tempo5x5+"\n";
    }


}
