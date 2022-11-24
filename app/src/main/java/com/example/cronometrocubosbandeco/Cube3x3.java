package com.example.cronometrocubosbandeco;

public class Cube3x3 {
    private long _id;
    private String tempo3x3;

    public Cube3x3(long _id, String tempo3x3){
        this._id = _id;
        this.tempo3x3 = tempo3x3;
    }

    public long get_id(){return _id; }
    public void set_id(long _id){this._id = _id; }
    public String getTempo3x3() {return tempo3x3; }
    public void setTempo3x3(String tempo) {this.tempo3x3 = tempo; }

    @Override
    public String toString(){
        return "\n" + "Tempo "+"\n"+tempo3x3+"\n";
    }

}
