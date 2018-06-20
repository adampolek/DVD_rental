/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.dao;

import file.model.KlientDTO;

/**
 *
 * @author student
 */
public interface KlientDao{
    public void save(KlientDTO t);
    public void delete (KlientDTO t);
    public void update (KlientDTO t);
    public KlientDTO findById(Long id);
}
