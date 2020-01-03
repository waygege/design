package com.ecut.design.Service.Impl;

import com.ecut.design.Repository.OptionRepository;
import com.ecut.design.Service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionImpl implements OptionService {

    @Autowired
    OptionRepository optionRepository;
}
