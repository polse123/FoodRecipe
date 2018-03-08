/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import acq.*;
import java.util.Map;

/**
 *
 * @author Bruger
 */
public interface SavableLoadable {

    public Map<String, String> load();

    public boolean save(Map<String, String> map);

    public boolean doesFileExist(String fileName);

    public boolean deleteFile(String fileName);

}
