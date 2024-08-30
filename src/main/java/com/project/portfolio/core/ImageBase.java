package com.project.portfolio.core;

import com.project.portfolio.core.utilities.ImageUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class ImageBase extends Base{

    @Lob
    @Column(name = "image")
    private byte[] image;


    public String getImageBase64() {
        if (image == null) {
            return null; // veya boş bir string dönebilirsiniz: return "";
        }
        String mimeType = ImageUtils.getImageMimeType(image);
        return ImageUtils.encodeImageToBase64(image, mimeType);
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}

