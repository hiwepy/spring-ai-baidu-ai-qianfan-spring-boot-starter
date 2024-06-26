package org.springframework.ai.baiduai.qianfan.autoconfigure;

import org.springframework.ai.document.MetadataMode;
import org.springframework.ai.baiduai.qianfan.BaiduAiQianfanEmbeddingOptions;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@ConfigurationProperties(BaiduAiQianfanEmbeddingProperties.CONFIG_PREFIX)
public class BaiduAiQianfanEmbeddingProperties {

    public static final String CONFIG_PREFIX = "spring.ai.baiduai.qianfan.embedding";

    public static final String DEFAULT_EMBEDDING_MODEL = "embedding-v1";

    /**
     * Enable 百度千帆 embedding client.
     */
    private boolean enabled = true;

    public MetadataMode metadataMode = MetadataMode.EMBED;

    /**
     * Client lever 百度千帆 options. Use this property to configure generative temperature,
     * topK and topP and alike parameters. The null values are ignored defaulting to the
     * generative's defaults.
     */
    @NestedConfigurationProperty
    private BaiduAiQianfanEmbeddingOptions options = BaiduAiQianfanEmbeddingOptions.builder()
            .withModel(DEFAULT_EMBEDDING_MODEL)
            .build();

    public BaiduAiQianfanEmbeddingOptions getOptions() {
        return this.options;
    }

    public void setOptions(BaiduAiQianfanEmbeddingOptions options) {
        this.options = options;
    }

    public MetadataMode getMetadataMode() {
        return this.metadataMode;
    }

    public void setMetadataMode(MetadataMode metadataMode) {
        this.metadataMode = metadataMode;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
