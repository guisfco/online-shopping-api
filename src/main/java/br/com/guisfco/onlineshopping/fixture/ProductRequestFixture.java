package br.com.guisfco.onlineshopping.fixture;

import br.com.guisfco.onlineshopping.domain.ProductRequest;
import com.google.common.collect.ImmutableList;

import java.math.BigDecimal;
import java.util.List;

import static br.com.guisfco.onlineshopping.util.RandomUtils.nextDouble;
import static br.com.guisfco.onlineshopping.util.RandomUtils.nextInt;

public class ProductRequestFixture {

    private final List<String> names = ImmutableList.of(
            "Panela de Pressão Tramontina Vancouver 4,5 Litros Alumínio - Grafite",
            "Monitor LED 29\" LG Ultrawide 21:9 com HDR 10 IPS Full HD (2560x1080) - Preto",
            "Gift Card Digital Google Play R$ 100 Recarga",
            "Cadeira de escritório Giratória Com Base Cromada - Preta - Mb-6010",
            "iPhone 11 Apple (64GB) Preto tela 6,1\" Câmera 12MP iOS",
            "Máscara Cirúrgica Tripla Com Antiviral (48 Horas de Duração) - Descartável",
            "Bicicleta Infantil Styll Baby Aro 12 - Princesinha",
            "Ovo Pascoa Nerf 130g Delicce",
            "Notebook Dell Inspiron I15-3583-D3XP Intel Core I5 8ª 8GB 1TB Linux 15\" - Preto",
            "Mini Câmera de Segurança Doméstica SQ11 com Visão Noturna"
    );

    private final ProductRequest fixture = new ProductRequest();

    public static ProductRequestFixture get() {
        return new ProductRequestFixture();
    }

    public ProductRequest build() {
        return fixture;
    }

    public ProductRequestFixture random() {

        fixture.setDescription("Sed hendrerit in est in sagittis. Integer dignissim quam nisi, id dignissim elit aliquet nec. Proin ut laoreet enim. Praesent dictum metus ac faucibus dictum. Curabitur luctus, mauris id fermentum feugiat, dolor ex fermentum lectus, non feugiat justo justo et tortor. Morbi pellentesque a nunc at venenatis. Sed tempus eu erat et pulvinar. Nam vel viverra turpis.");
        fixture.setName(names.get(0));
        fixture.setEnabled(true);
        fixture.setImageUrl("");
        fixture.setPrice(new BigDecimal(200));
        fixture.setStockLevel(999);

        return this;
    }
}
