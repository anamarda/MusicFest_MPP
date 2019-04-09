package utils;

import domain.DTO_ArtistShow;

public class DTO_artistShowEvent implements Event{
    private DTO_ArtistShow oldData;
    private DTO_ArtistShow newData;
    private ChangeEventType type;

    public DTO_artistShowEvent(DTO_ArtistShow oldData, DTO_ArtistShow newData, ChangeEventType type) {
        this.oldData = oldData;
        this.newData = newData;
        this.type = type;
    }

    public DTO_ArtistShow getOldData() {
        return oldData;
    }

    public void setOldData(DTO_ArtistShow oldData) {
        this.oldData = oldData;
    }

    public DTO_ArtistShow getNewData() {
        return newData;
    }

    public void setNewData(DTO_ArtistShow newData) {
        this.newData = newData;
    }

    public ChangeEventType getType() {
        return type;
    }

    public void setType(ChangeEventType type) {
        this.type = type;
    }
}
