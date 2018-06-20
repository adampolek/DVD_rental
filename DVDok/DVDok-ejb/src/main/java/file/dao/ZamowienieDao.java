/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.dao;

import file.model.ZamowienieDTO;

/**
 *
 * @author student
 */
public interface ZamowienieDao{
    public void save(ZamowienieDTO t);
    public void delete (ZamowienieDTO t);
    public void update (ZamowienieDTO t);
    public ZamowienieDTO findById(Long id);
}
