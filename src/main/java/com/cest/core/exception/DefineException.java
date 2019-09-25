package com.cest.core.exception;

import com.cest.common.util.CodeMsg;

/**
 * 自定义异常
 * Created by cestlavie on 2019/9/23.
 */
public class DefineException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private CodeMsg cm;

    public DefineException(CodeMsg cm) {
        super(cm.toString());
        this.cm = cm;
    }

    public CodeMsg getCm() {
        return cm;
    }
}
