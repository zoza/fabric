package com.example.restservice.services;

import com.example.restservice.api.AllocateCellRequest;
import com.example.restservice.api.AllocateCellResponse;
import com.example.restservice.models.Cell;
import com.example.restservice.models.Product;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;

@Service
public class StorageService {

    private HashSet<Product> availableProducts = new HashSet<>();

    private ArrayList<ArrayList<Cell>> storage = new ArrayList<>();

    public StorageService(){
        availableProducts.add(new Product("milk",true,false));
        availableProducts.add(new Product("yogurt",true,false));
        availableProducts.add(new Product("cheese",true,false));
        availableProducts.add(new Product("insulin",true,true));
        availableProducts.add(new Product("bleach",false,true));
        availableProducts.add(new Product("stain removal",false,true));
        availableProducts.add(new Product("bread"));
        availableProducts.add(new Product("pasta"));
        availableProducts.add(new Product("salt"));
        availableProducts.add(new Product("bamba"));
        availableProducts.add(new Product("apple"));

        boolean hazard = false;
        boolean cool = false;

        for (int i = 0;i < 10;i++) {
            ArrayList<Cell> row = new ArrayList<>();
            for (int j=0;j<10;j++){
                if(j==9){
                    hazard = true;
                }
                if(i>=7 || j >=7){
                    cool = true;
                }
                row.add(j, new Cell(10,cool,hazard));
            }
            storage.add(row);
        }
        this.addProductToCell(0,1,new Product("bread",false,false));
        this.addProductToCell(0,1,new Product("bread",false,false));
        this.addProductToCell(0,1,new Product("bread",false,false));

    }




    public void addProductToCell(int rowIndex, int colIndex, Product product){

        //TODO add in batch
    }

    private boolean matchRules(Product p, Cell cell){
        if(p.isRequireCool() == cell.isCool() && p.isRequireHazard() == cell.isHazard()){
            return true;
        }
        return false;
    }

    public Cell getGoodCellFor(Product p){
        for (int i = 0;i < 10;i++) {
            for (int j=0;j<10;j++){
                Cell cell = storage.get(i).get(j);
                if( cell.getProduct() == null || (cell.getProduct().equals(p.getName()) && cell.getCapacity() <10)){
                    return cell;
                }
            }

        }
        throw new RuntimeException("no free cells");
    }

    public Cell getCell(int rowIndex, int colIndex){

        ArrayList<Cell> row = storage.get(rowIndex);
        if(row == null){
            throw new RuntimeException("row "+ rowIndex +" not exist");
        }
       return row.get(colIndex);
    }

    public boolean validate(AllocateCellRequest req){
        this.sanityCheck(req);

        return false;
    }


    public void sanityCheck(AllocateCellRequest req){

        if(!Strings.isNotEmpty(req.getProductId()) ){
            // TODO client 400
            throw new RuntimeException("product name is empty");
        }

        if(availableProducts.stream().noneMatch(product -> product.getName().equals(req.getProductId()))){
            // TODO client 400
            throw new RuntimeException("product "+req.getProductId() +" dosn't supported");
        }

    }

    public AllocateCellResponse allocateCell(AllocateCellRequest req){
        //TODO logs
        if(this.validate(req)){
            return new AllocateCellResponse(true,"1,1");
        }else{
            return new AllocateCellResponse(false,null);
        }

    }

}
