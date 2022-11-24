package com.example.cronometrocubosbandeco;

public class Cube4x4 {

    private long _id;
    private String tempo4x4;

    public Cube4x4(long _id, String tempo4x4){
        this._id = _id;
        this.tempo4x4 = tempo4x4;
    }

    public long get_id(){return _id; }
    public void set_id(long _id){this._id = _id; }
    public String getTempo4x4() {return tempo4x4; }
    public void setTempo4x4(String tempo) {this.tempo4x4 = tempo; }

    @Override
    public String toString(){
        return "\n" + "Tempo "+"\n"+tempo4x4+"\n";
    }
}
