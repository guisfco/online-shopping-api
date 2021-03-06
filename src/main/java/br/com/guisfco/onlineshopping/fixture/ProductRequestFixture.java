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

        fixture.setDescription("Descrição do produto.");
        fixture.setName(names.get(nextInt(0, names.size())));
        fixture.setEnabled(true);
        fixture.setImageUrl("");
        fixture.setPrice(BigDecimal.valueOf(nextDouble(10, 2000)));
        fixture.setStockLevel(999);

        return this;
    }
}
