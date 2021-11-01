package com.example.restservice.api;

public class AllocateCellResponse {

    private boolean foundCell;
    private String cell;

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public AllocateCellResponse(boolean foundCell, String cell) {
        this.foundCell = foundCell;
        this.cell = cell;
    }

    public boolean isFoundCell() {
        return foundCell;
    }

    public void setFoundCell(boolean foundCell) {
        this.foundCell = foundCell;
    }
}
