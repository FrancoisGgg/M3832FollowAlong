package gfx;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SpriteLibrary {
    //La liste de tous les personnages
    private final static String PATH_TO_UNITS = "/sprites/units";

    private Map<String, SpriteSet> units;

    public SpriteLibrary() {
        this.units = new HashMap<>();
        loadSpritesFromDisk();
    }

    //load toutes les images
    private void loadSpritesFromDisk(){
        String[] folderNames = getFolderNames(PATH_TO_UNITS);

        for (String folderName : folderNames){
            SpriteSet spriteSet = new SpriteSet();
            String pathToFolder = PATH_TO_UNITS + "/" + folderName;
            String[] sheetsInFolder = getSheetsInFolder(pathToFolder);

            for (String sheetName : sheetsInFolder){
                spriteSet.addSheet(
                        sheetName.substring(0,sheetName.length()-4),
                        ImageUtils.loadImage(pathToFolder + "/" + sheetName)
                );
            }
            units.put(folderName,spriteSet);
        }
    }

    //Donne les nom des dir des sheets d'images de chaque personnage
    private String[] getSheetsInFolder(String basePath){
        URL resource = SpriteLibrary.class.getResource(basePath);
        File file = new File(resource.getFile());
        return file.list((current, name)-> new File(current,name).isFile());
    }

    //Donne les nom des dir de chaque personnage
    private String[] getFolderNames(String basePath){
        URL resource = getClass().getResource(basePath);
        File file = new File(resource.getFile());
        String s = resource.getPath();
        return file.list((current, name)-> new File(current,name).isDirectory());

    }

    public SpriteSet getUnit(String name) {
        return units.get(name);
    }
}
