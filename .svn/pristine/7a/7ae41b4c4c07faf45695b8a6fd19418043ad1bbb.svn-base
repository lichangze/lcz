/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.bmzy.report.baseService;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;

import com.bmzy.report.util.DataSource;
import com.bmzy.report.util.DbcontextHolder;

import tk.mybatis.mapper.common.Mapper;


/**
 * 
 * @author July_whj
 *
 * @param <T>
 * @param <E>
 */
public abstract class BaseService<E>  implements IService<E> {

    @Autowired
    protected Mapper<E> mapper;

    public Mapper<E> getMapper() {
        return mapper;
    }
    @DataSource
    public E selectByKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }
    @DataSource
    public int save(E entity) {
        return mapper.insert(entity);
    }
    @DataSource
    public int delete(Object key) {
        return mapper.deleteByPrimaryKey(key);
    }
    @DataSource
    public int updateAll(E entity) {
        return mapper.updateByPrimaryKey(entity);
    }
    @DataSource
    public int updateNotNull(E entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }
    @DataSource
    public List<E> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }
    @DataSource
    public List<E> selectByExample2(Object example) {
        return mapper.selectByExampleAndRowBounds(example, RowBounds.DEFAULT);
    }
    @DataSource
    public List<E> selectByother(Object example){
		return mapper.selectByExample(example);
    }
    @DataSource(value = DbcontextHolder.DATA_SOURCE_LOG)
    public int saveLog(E entity) {
        return mapper.insert(entity);
    }
    @DataSource(value = DbcontextHolder.DATA_SOURCE_LOG)
    public List<E> selectByExampleLog(Object example) {
        return mapper.selectByExample(example);
    }
    
  
    
    //TODO 其他...
}
