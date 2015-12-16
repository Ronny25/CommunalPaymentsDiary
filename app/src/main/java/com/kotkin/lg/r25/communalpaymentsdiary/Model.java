package com.kotkin.lg.r25.communalpaymentsdiary;

public class Model {
    boolean box;
    String service;
    String sum;

    Model(String _service, String _sum, boolean _box) {
        service = _service;
        sum = _sum;
        box = _box;
    }
}
