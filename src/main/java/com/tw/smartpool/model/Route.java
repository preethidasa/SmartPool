package com.tw.smartpool.model;

public class Route {
    private int id;
    private int totalPoints;
    String[] points;
    public Route(int id, int totalPoints, String[] p) {
        this.id = id;
        this.totalPoints = totalPoints;
        this.points = new String[this.totalPoints];
        for(int i=0; i<this.totalPoints; i++) {
            this.points[i] = p[i];
        }
    }

    public boolean hasPoint(String p) {
        for(String point: points) {
            if( point.equals(p)) return true;
        }
        return false;
    }
    
    public boolean equals(Object obj) {
        if(obj==null) return false;
        if(this.getClass() != obj.getClass() ) return false;
        if( this.id != ((Route)obj).id ) return false;
        if( this.totalPoints != ((Route)obj).totalPoints ) return false;
        for(int i=0; i<totalPoints; i++) {
            if( ! this.points[i].equals(((Route)obj).points[i]) ) return false;
        }
        return true;
    }
}
