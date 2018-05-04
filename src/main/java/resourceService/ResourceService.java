package resourceService;

import resources.TestResource;

public class ResourceService implements ResourceServiceI {
   private TestResource res;

    @Override
    public TestResource getResource() {
        return res;
    }

    @Override
    public void setResource(TestResource res) {
        this.res = res;
    }


}
