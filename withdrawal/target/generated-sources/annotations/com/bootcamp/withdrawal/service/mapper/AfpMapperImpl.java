package com.bootcamp.withdrawal.service.mapper;

import com.bootcamp.withdrawal.domain.Afp;
import com.bootcamp.withdrawal.web.model.AfpModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-12T15:19:35-0500",
    comments = "version: 1.5.2.Final, compiler: Eclipse JDT (IDE) 1.4.100.v20220318-0906, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class AfpMapperImpl implements AfpMapper {

    @Override
    public Afp afpModelToAfp(AfpModel model) {
        if ( model == null ) {
            return null;
        }

        Afp.AfpBuilder afp = Afp.builder();

        afp.id( model.getId() );
        afp.name( model.getName() );

        return afp.build();
    }

    @Override
    public AfpModel afpToAfpModel(Afp domain) {
        if ( domain == null ) {
            return null;
        }

        AfpModel afpModel = new AfpModel();

        afpModel.setId( domain.getId() );
        afpModel.setName( domain.getName() );

        return afpModel;
    }

    @Override
    public List<AfpModel> afpsToAfpModels(List<Afp> domain) {
        if ( domain == null ) {
            return null;
        }

        List<AfpModel> list = new ArrayList<AfpModel>( domain.size() );
        for ( Afp afp : domain ) {
            list.add( afpToAfpModel( afp ) );
        }

        return list;
    }

    @Override
    public void update(Afp entity, AfpModel updateEntity) {
        if ( updateEntity == null ) {
            return;
        }

        entity.setName( updateEntity.getName() );
    }
}
